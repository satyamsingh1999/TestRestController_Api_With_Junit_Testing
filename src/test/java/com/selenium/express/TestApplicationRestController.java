package com.selenium.express;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selenium.express.dto.Student;
import com.selenium.express.service.StudentServiceImpl;

@WebMvcTest
public class TestApplicationRestController {

	@MockBean
	private StudentServiceImpl studentService;

	@Autowired
	private MockMvc mockMvc;

	@Disabled
	public void testSaveStudent() throws Exception {

		Student student = new Student(1, "Abhilash", "Panigrahi", "Blr");
		ObjectMapper objectMapper = new ObjectMapper();
		String studentJson = objectMapper.writeValueAsString(student);

		when(studentService.addStudent(ArgumentMatchers.any())).thenReturn(student);

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/student/save")
				.contentType(MediaType.APPLICATION_JSON).content(studentJson);

		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult result = perform.andReturn();
		MockHttpServletResponse response = result.getResponse();

		int status = response.getStatus();
		assertEquals(200, status);
	}

	@Test
	public void testFindStudentById() throws Exception {
		when(studentService.findById(1)).thenReturn(new Student(1, "Satyam", "singh", "pune"));

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/student/findStudentById/1");

		ResultActions perform = mockMvc.perform(requestBuilder);

		MvcResult result = perform.andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();

		assertEquals(200, status);
	}
	

}
