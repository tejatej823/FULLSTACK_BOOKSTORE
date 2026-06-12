package org.example.backend.service;
import org.example.backend.dto.request.CategoryRequestDto;
import org.example.backend.dto.response.CategoryResponseDto;
import org.example.backend.exception.CategoryExceptions.CategoryAlreadyExistsException;
import org.example.backend.exception.CategoryExceptions.CategoryNotFoundException;
import org.example.backend.mapper.CategoryMapper;
import org.example.backend.model.Category;
import org.example.backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryMapper categoryMapper,CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto) {
        Category newCategory=categoryMapper.toEntity(categoryRequestDto);
        boolean checkAlreadyExisted= categoryRepository.existsBycategoryName(categoryRequestDto.getCategoryName());
        if(checkAlreadyExisted){
            throw new CategoryAlreadyExistsException("Category already exists!!");
        }
        categoryRepository.save(newCategory);
        return categoryMapper.toDto(newCategory);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories(){
        List<Category>categoryList=categoryRepository.findAll();
        return categoryMapper.toListDto(categoryList);
    }

    @Override
    public CategoryResponseDto getCategoryById(Integer id){
        Category requestedCategory=categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException("Category not found"));
        return categoryMapper.toDto(requestedCategory);
    }

    @Override
    public void deleteCategoryById(Integer id){
        boolean checkAlreadyExisted=categoryRepository.existsById(id);
        if(!checkAlreadyExisted){
            throw new CategoryNotFoundException("Requested category did not exist");
        }
        categoryRepository.deleteById(id);
    }
}
