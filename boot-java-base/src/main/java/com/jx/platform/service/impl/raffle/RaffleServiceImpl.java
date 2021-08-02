package com.jx.platform.service.impl.raffle;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jx.platform.common.exception.BussinessException;
import com.jx.platform.dao.raffle.RaffleAwardMapper;
import com.jx.platform.dao.raffle.RaffleDetailMapper;
import com.jx.platform.dao.raffle.RaffleMainMapper;
import com.jx.platform.dto.raffle.RaffleListDto;
import com.jx.platform.dto.raffle.RaffleMainInsertDto;
import com.jx.platform.dto.raffle.RaffleResultUploadDto;
import com.jx.platform.dto.raffle.RaffleStatusDto;
import com.jx.platform.entity.raffle.RaffleAward;
import com.jx.platform.entity.raffle.RaffleDetail;
import com.jx.platform.entity.raffle.RaffleMain;
import com.jx.platform.service.raffle.RaffleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RaffleServiceImpl implements RaffleService {

    @Autowired
    private RaffleMainMapper raffleMainMapper;
    @Autowired
    private RaffleAwardMapper raffleAwardMapper;

    @Autowired
    private RaffleDetailMapper raffleDetailMapper;

    @Override
    @Transactional
    public int insertRaffle(RaffleMainInsertDto dto) {
        validLotNo(dto.getLotNo());
        createRaffleDetail(dto);
        RaffleMain main = new RaffleMain();
        BeanUtils.copyProperties(dto, main);
        main.setStatus(0);
        return raffleMainMapper.insertSelective(main);
    }

    private void createRaffleDetail(RaffleMainInsertDto dto) {
        List<RaffleDetail> details = new ArrayList<>();
        dto.getAwards().stream().forEach(item -> {
            RaffleAward award = new RaffleAward();
            BeanUtils.copyProperties(item, award);
            award.setLotNo(dto.getLotNo());
            raffleAwardMapper.insertSelective(award);
            for (int i = 0; i < award.getPrizesNum(); i++) {
                RaffleDetail detail = new RaffleDetail();
                detail.setLotNo(dto.getLotNo());
                detail.setPrizesId(award.getId());
                details.add(detail);
            }
        });
        final int start = details.size();
        for (int i = start; i < dto.getTotalNum(); i++) {
            RaffleDetail detail = new RaffleDetail();
            detail.setLotNo(dto.getLotNo());
            details.add(detail);
        }
        Collections.shuffle(details);
        int i = 1;
        for (RaffleDetail detail : details) {
            detail.setPick("N");
            detail.setSortNum(i++);
            raffleDetailMapper.insertSelective(detail);
        }


    }

    @Override
    public RaffleMain getRaffleMainInfo(String lotNo) {
        RaffleMain main = raffleMainMapper.selectByPrimaryKey(lotNo);
        if (main == null) {
            throw new BussinessException("批次号不存在！");
        }
        main.setAwards(raffleAwardMapper.selectByLotNo(lotNo));
        return main;
    }

    @Override
    @Transactional
    public int updateRaffle(RaffleMainInsertDto dto) {
        RaffleMain main = validLotNo(dto.getLotNo());
        if (main.getStatus() == 1) {
            throw new BussinessException("抽奖进行中无法更新！");
        }
        main = new RaffleMain();
        BeanUtils.copyProperties(dto, main);
        raffleAwardMapper.deleteByLotNo(dto.getLotNo());
        createRaffleDetail(dto);
        return this.raffleMainMapper.updateByPrimaryKeySelective(main);
    }

    @Override
    @Transactional
    public int deleteRaffle(String lotNo) {
        RaffleMain main = validLotNo(lotNo);
        if (main.getStatus() == 1) {
            throw new BussinessException("抽奖进行中无法删除！");
        }
        raffleAwardMapper.deleteByLotNo(lotNo);
        raffleDetailMapper.deleteByLotNo(lotNo);
        return raffleMainMapper.deleteByPrimaryKey(lotNo);
    }

    @Override
    @Transactional
    public int reStartRaffle(RaffleStatusDto dto) {
        validLotNo(dto.getLotNo());
        RaffleMain main = new RaffleMain();
        BeanUtils.copyProperties(dto, main);
        main.setStatus(1);
        raffleDetailMapper.resetPick(dto.getLotNo());
        return this.raffleMainMapper.updateByPrimaryKeySelective(main);
    }


    @Override
    @Transactional
    public int raffleResultUpload(RaffleResultUploadDto dto) {
        RaffleMain main = validLotNo(dto.getLotNo());
        if (main.getStatus() == 0) {
            throw new BussinessException("抽奖尚未开始！");
        }
        if (main.getStatus() == 2) {
            throw new BussinessException("抽奖已结束！");
        }
        RaffleDetail detail = new RaffleDetail();
        BeanUtils.copyProperties(dto, detail);
        detail.setPick("Y");
        int res = raffleDetailMapper.updateByPrimaryKeySelective(detail);
        int x = raffleDetailMapper.countNoPickNum(dto.getLotNo());
        if (x == 0) {
            main = new RaffleMain();
            main.setStatus(2);
            main.setLotNo(dto.getLotNo());
            raffleMainMapper.updateByPrimaryKeySelective(main);
        }
        return res;
    }

    @Override
    public PageInfo<RaffleMain> pageRaffleMain(RaffleListDto dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        List<RaffleMain> list = raffleMainMapper.selectRaffleMainList(dto);
        return new PageInfo<>(list);
    }

    @Override
    public List<RaffleDetail> listRaffleDetail(String lotNo) {
        RaffleMain main = validLotNo(lotNo);
        List<RaffleDetail> list = raffleDetailMapper.selectByLotNo(lotNo);
        list.stream().forEach(item -> {
            if (StringUtils.isEmpty(item.getPrizesName())) {
                item.setPrizesName(main.getNoPrizesMsg());
            }
        });
        return list;
    }

    private RaffleMain validLotNo(String lotNo) {
        RaffleMain main = raffleMainMapper.selectByPrimaryKey(lotNo);
        if (main == null) {
            throw new BussinessException("批次号不存在！");
        }
        return main;
    }
}
