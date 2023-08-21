package com.alibou.project2023TMA.service;

import com.alibou.project2023TMA.entity.user_model;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface user_modelService {


    List<user_model> getAllUserModel();
    user_model saveUserModel(user_model userModel);

    Object getUserModel(BigInteger userModelId);

    List<user_model> getUserModelNotDeleted();

    user_model updateUserModel(BigInteger userModelId, Map<String, String> formData);
}
