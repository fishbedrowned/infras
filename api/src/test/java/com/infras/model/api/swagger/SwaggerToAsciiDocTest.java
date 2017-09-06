package com.infras.model.api.swagger;

import com.infras.api.config.SwaggerConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;

import javax.annotation.Resource;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Created by zhaoheng on 2017/9/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SwaggerToAsciiDocTest {
    @Resource
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void convertSwaggerToAsciiDoc() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs?group=" + SwaggerConfig.SWAGGER_GROUP)
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(Swagger2MarkupResultHandler.outputDirectory("src/docs/asciidoc/generated").build())
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
