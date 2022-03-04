package com.fungus.fungusApp;

import static org.junit.Assert.assertEquals;

import com.fungus.fungusapp.ops.BasicOps;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class FungusControllerTest extends FungusControllerAbstractTest {
    @Override
    @Before
    public void setUp() {
       super.setUp();
    }

@Test
public void getRandom() throws Exception {
   String uri = "/basic/random";
   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
   
   //int status = mvcResult.getResponse().getStatus();
   //assertEquals(200, status);
   //String content = mvcResult.getResponse().getContentAsString();
   //BasicOps[] randomlist = super.mapFromJson(content, BasicOps[].class);
   //assertTrue(randomlist.length > 0);
}
    
}
