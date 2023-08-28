package com.catalog.mappers;

import com.catalog.apimodel.StudentDTO;
import com.catalog.models.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "name", target = "studentName")
    @Mapping(source = "studentGroup", target = "studentClass")
    @Mapping(source = "academicYear", target = "year")
    StudentDTO studentToStudentDTO(Student student);

    @Mapping(source = "studentName", target = "name")
    @Mapping(source = "studentClass", target = "studentGroup")
    @Mapping(source = "year", target = "academicYear")
    Student studentDTOtoStudent(StudentDTO studentDTO);
}
