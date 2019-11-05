package fr.houseofcode.dap.ws.web;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

import fr.houseofcode.dap.ws.GoogleFacade;

/**
 * .
 */

@RunWith(SpringRunner.class) // permet d'utiliser junit
@WebMvcTest(Events.class) //test sur events
@ComponentScan({ "fr.houseofcode.dap.ws" })
/**
 * .
 */
public class EventsTest {
    /**
     * .
     */
    @Autowired
    private MockMvc mvc;

    /**
     * .
     */
    @MockBean
    private GoogleFacade service;

    /**
     * get next event.
     *  @throws Exception : .
     */
    @Test
    public void testNextEvent() throws Exception {

        Event evt = new Event();
        evt.setSummary("Toto");
        EventDateTime edt = new EventDateTime();
        Date javaDate = new Date();
        DateTime dt = new DateTime(javaDate);
        edt.setDateTime(dt);
        evt.setStart(edt);
        evt.setStatus("tentative");

        BDDMockito.given(service.getNextEvent("virginie")).willReturn(evt);
        BDDMockito.given(service.display("virginie", evt))
                .willReturn(evt.getSummary() + "[" + evt.getStart() + "] " + evt.getStatus());

        mvc.perform(MockMvcRequestBuilders.get("/events/next").contentType(MediaType.TEXT_PLAIN_VALUE).param("userId",
                "virginie")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string(evt.getSummary() + "[" + evt.getStart() + "] " + evt.getStatus()));
    }

    @Test
    public void testNextEventJson() throws Exception {

        Event evt = new Event();
        evt.setSummary("Toto");
        EventDateTime edt = new EventDateTime();
        Date javaDate = new Date();
        DateTime dt = new DateTime(javaDate);
        edt.setDateTime(dt);
        evt.setStart(edt);
        evt.setStatus("tentative");

        BDDMockito.given(service.getNextEvent("djer")).willReturn(evt);

        mvc.perform(MockMvcRequestBuilders
                .get("/events/next").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).param("userId", "djer"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"start\":{\"dateTime\":{\"value\":"
                        + javaDate.getTime()
                        + ",\"dateOnly\":false,\"timeZoneShift\":60}},\"status\":\"tentative\",\"summary\":\"Toto\"}"));
    }
}
