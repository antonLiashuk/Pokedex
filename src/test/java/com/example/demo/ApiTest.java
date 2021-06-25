package com.example.demo;

import com.example.demo.controller.PokemonController;
import com.example.demo.model.Pokemon;
import com.example.demo.service.PokemonService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(PokemonController.class)
//@AutoConfigureMockMvc
public class ApiTest {

    private String toJson(Pokemon pokemon) {
        return new Gson().toJson(pokemon).toString();
    }

    @Autowired
    private MockMvc mvc;

    @MockBean
    PokemonService pokemonService;

    @Test
    public void saveTest() throws Exception {
        Pokemon pokemon = Pokemon.createPokemon();

        mvc.perform(post("/api/pokemon")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(pokemon)))
                .andExpect(status().isOk());
    }
}
