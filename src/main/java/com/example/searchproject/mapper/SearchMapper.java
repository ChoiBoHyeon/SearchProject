package com.example.searchproject.mapper;

import com.example.searchproject.dto.SearchDto;
import com.example.searchproject.model.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchMapper {
    void createPost(SearchDto searchDto);

    SearchDto findID(Integer id);

    void change(SearchDto searchDto);

    void delete(Integer id);

    List<SearchDto> getListPaging(Criteria cri);

    List<SearchDto> titlesearch(
            @Param("tilte") String title
    );
}
