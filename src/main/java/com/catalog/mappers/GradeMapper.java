package com.catalog.mappers;

import com.catalog.apimodel.GradeDTO;
import com.catalog.models.Grade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GradeMapper {

    GradeMapper INSTANCE = Mappers.getMapper(GradeMapper.class);

    @Mapping(source = "examinationId", target = "examId")
    @Mapping(source = "studId", target = "studentId")
    @Mapping(source = "receivedGrade", target = "grade")
    Grade gradeDTOtoGrade(GradeDTO gradeDTO);
}
