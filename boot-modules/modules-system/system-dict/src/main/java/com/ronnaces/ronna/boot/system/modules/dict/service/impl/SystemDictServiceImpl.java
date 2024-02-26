package com.ronnaces.ronna.boot.system.modules.dict.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.modules.dict.entity.SystemDict;
import com.ronnaces.ronna.boot.system.modules.dict.mapper.SystemDictMapper;
import com.ronnaces.ronna.boot.system.modules.dict.service.ISystemDictService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * SystemDictServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@AllArgsConstructor
@Service
public class SystemDictServiceImpl extends ServiceImpl<SystemDictMapper, SystemDict> implements ISystemDictService {

    private final SystemDictMapper mapper;

}

