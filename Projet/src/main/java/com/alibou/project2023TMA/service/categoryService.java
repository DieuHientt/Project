package com.alibou.project2023TMA.service;



import com.alibou.project2023TMA.entity.category;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface categoryService {
    List<category> getAllCategory();
    category saveCategory(category category);

    Object getCategory(BigInteger categoryId);

    List<category> getCategoryNotDeleted();

    category updateCategory(BigInteger categoryId, Map<String, String> formData);
}
//