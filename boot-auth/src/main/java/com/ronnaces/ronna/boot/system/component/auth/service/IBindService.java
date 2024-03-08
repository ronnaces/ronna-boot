package com.ronnaces.ronna.boot.system.component.auth.service;

import java.util.List;


public interface IBindService {

    void bindRole(String mainId, List<String> minorIds);

    void bindPermission(String mainId, List<String> minorIds);

    void bindDepartment(String mainId, List<String> minorIds);

    void unbindRole(String mainId, List<String> minorIds);

    void unbindPermission(String mainId, List<String> minorIds);

    void unbindDepartment(String mainId, List<String> minorIds);
}
