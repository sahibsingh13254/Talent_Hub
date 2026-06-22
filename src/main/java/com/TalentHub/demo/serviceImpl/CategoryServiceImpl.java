package com.TalentHub.demo.serviceImpl;

import com.TalentHub.demo.dto.CategoryResponse;
import com.TalentHub.demo.entity.Category;
import com.TalentHub.demo.repository.CategoryRepository;
import com.TalentHub.demo.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CategoryResponse> getAllCategories(){

        List<Category>categories = categoryRepository.findAll(); // get all categories entites from db

         return categories.stream()
                .map(category -> modelMapper.map(category,CategoryResponse.class))
                .toList();


    }


}
