package com.summit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.summit.resource.MessageResource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TwitterMessageProducerApplication.class)
@WebAppConfiguration
public class TwitterMessageProcessApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MessageResource messageResource;

	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void test() throws Exception {
		for (int i = 0; i < 1000; i++) {
			mockMvc.perform( post( "/message" ).content( "Kotlin é foda pa caralho" ) )
					.andExpect( status().isOk() );
		}
	}

	@Test
	public void test2() throws Exception {
		for (int i = 0; i < 1000; i++) {
			messageResource.createMessage( "Kotlin é foda pa caralho" );
		}
	}


}
