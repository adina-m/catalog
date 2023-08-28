package com.catalog.mappers;

import com.catalog.apimodel.ExamDTO;
import com.catalog.models.Exam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExamMapper {

    ExamMapper INSTANCE = Mappers.getMapper(ExamMapper.class);

    @Mapping(source = "id", target = "examId")
    @Mapping(source = "className", target = "group")
    @Mapping(source = "professorName", target = "name")
    @Mapping(source = "examDate", target = "date")
    ExamDTO examToExamDTO(Exam exam);

    @Mapping(source = "examId", target = "id")
    @Mapping(source = "group", target = "className")
    @Mapping(source = "name", target = "professorName")
    @Mapping(source = "date", target = "examDate")
    Exam examDTOtoExam(ExamDTO examDTO);
}
