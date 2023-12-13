package com.ronnaces.ronna.boot.system.management.dict.item.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ronnaces.ronna.boot.system.management.dict.item.entity.SystemDictItem;
import com.ronnaces.ronna.boot.system.management.dict.item.mapper.SystemDictItemMapper;
import com.ronnaces.ronna.boot.system.management.dict.item.service.ISystemDictItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * SystemDictItemServiceImpl
 *
 * @author KunLong-Luo
 * @version 1.0.0
 * @since 2023-12-13
 */
@AllArgsConstructor
@Service
public class SystemDictItemServiceImpl extends ServiceImpl<SystemDictItemMapper, SystemDictItem> implements ISystemDictItemService {

    private final SystemDictItemMapper mapper;

}

