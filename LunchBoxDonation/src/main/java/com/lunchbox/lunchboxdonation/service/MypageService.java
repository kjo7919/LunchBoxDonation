package com.lunchbox.lunchboxdonation.service;

import com.lunchbox.lunchboxdonation.entity.Order.OrderAddress;
import com.lunchbox.lunchboxdonation.repository.LikesRepository;
import com.lunchbox.lunchboxdonation.repository.OrderAddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MypageService {
    
    private final OrderAddressRepository orderAddressRepository;
//    private final LikesRepository likesRepository;


//  주문내역
    public Page<OrderAddress> getRecentOrderAddressesWithinThreeMonthsPageable(int pageNumber, int pageSize) {
        LocalDateTime threeMonthsAgo = LocalDateTime.now().minusMonths(3);
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return orderAddressRepository.findByModDateAfter(threeMonthsAgo, pageable);
    }


//  찜하기
//    public Page<LikesItem> getLikedLunchboxesPageable(Member dummyMember, int pageNumber, int pageSize) {
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
//        return likesRepository.findByMember(dummyMember,pageable);
//    }



}
