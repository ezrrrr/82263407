package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.UserInfo;
import com.example.demo.dto.UserInfoDto;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserInfoService {

	private final UserInfoRepository userInfoRepository;
	
    /**
     * 수정하려는 TodoItem 정보 조회
     *
     * @param id
     * @return
     */

    @Transactional(readOnly = true)
    public UserInfoDto getUserInfo(Long id) {
    	UserInfo userInfo = userInfoRepository.getOne(id);

        // TotoItem 의 값을 TodoItemDto 에 전달
    	UserInfoDto userInfoDto = UserInfoDto.builder()
                .id(id)
                .name(userInfo.getName())
                .regDate(userInfo.getRegDate())
                .modDate(userInfo.getModDate())
                .build();

        return userInfoDto;
    }

    
}
