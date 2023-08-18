package com.lunchbox.lunchboxdonation.service.lunchbox;


import com.lunchbox.lunchboxdonation.domain.lunchbox.LunchBoxDTO;
import com.lunchbox.lunchboxdonation.entity.Lunchbox.LunchBox;
import com.lunchbox.lunchboxdonation.entity.Lunchbox.LunchBoxSearch;
import com.lunchbox.lunchboxdonation.repository.lunchbox.LunchBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LunchBoxServiceImpl implements LunchBoxService {
    private final LunchBoxRepository lunchBoxRepository;

    @Override
    public Long lunchBoxInsert(LunchBoxDTO lunchBoxDTO) {
        return lunchBoxRepository.save(toEntity(lunchBoxDTO)).getId();
    }

    @Override
    public Page<LunchBoxDTO> lunchBoxList(Pageable pageable, LunchBoxSearch lunchBoxSearch) {
        return lunchBoxRepository.lunchBoxList(pageable,lunchBoxSearch);
    }

    @Override
    public LunchBox getLunchBoxWithOptionByLunchBoxId(Long id) {

        return lunchBoxRepository.lunchBoxDetail(id);
    }

    @Override
    public void deleteLunchBoxAndOptionsByLunchBoxId(Long id) {
        lunchBoxRepository.deleteById(id);
    }
}
