package com.test;

import com.test.guest.controller.CityController;
import com.test.guest.model.City;
import com.test.guest.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
@Slf4j
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CityService cityService;

    private final String URL = "/city/get/";

    @Test
    public void testGetCity() throws Exception {

        log.info("testGetCity() Statred");
        // prepare data and mock's behaviour
        City empStub = new City("Jaipur",12000);
        when(cityService.findCityById(any(Long.class))).thenReturn(empStub);

        // execute
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get(URL + "{id}", new Long(1))
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        // verify
        int status = result.getResponse().getStatus();
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);

        // verify that service method was called once
        verify(cityService).findCityById(any(Long.class));

        City resultCity = TestUtils.jsonToObject(result.getResponse()
                .getContentAsString(), City.class);
        assertNotNull(resultCity);
        assertEquals(1l, resultCity.getId().longValue());

        log.info("testGetCity() Tested Sucessfully");
    }


}
