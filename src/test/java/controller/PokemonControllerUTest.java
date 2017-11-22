package controller;

import com.google.gson.Gson;
import dto.PokemonDTO;
import factory.HttpClientFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import service.PokemonService;

import static constant.StatusCodes.clientError;
import static constant.StatusCodes.noContent;
import static constant.StatusCodes.ok;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static spark.Spark.awaitInitialization;

public class PokemonControllerUTest {

    private static Gson gson;
    private static PokemonService mockPokemonService;
    private static HttpClientFactory httpClientFactory;

    @BeforeClass
    public static void setupClass() throws Exception {
        gson = new Gson();
        mockPokemonService = mock(PokemonService.class);
        new PokemonController(gson, mockPokemonService);
        httpClientFactory = new HttpClientFactory();
        awaitInitialization();
    }

    @After
    public void tearDown() throws Exception {
        reset(mockPokemonService);
    }

    @Test
    public void getPokemonById() throws Exception {
        String testUrl = "http://localhost:4567/pokemon/1";
        HttpGet httpGet = new HttpGet(testUrl);
        PokemonDTO pokemonDTO = new PokemonDTO.PokemonDTOBuilder()
                .withAbility("Blaze")
                .withNickname("Pizza")
                .build();

        when(mockPokemonService.getPokemonById(1L)).thenReturn(pokemonDTO);

        HttpResponse httpResponse = httpClientFactory.getHttpClient().execute(httpGet);
        String retStr = EntityUtils.toString(httpResponse.getEntity());
        assertEquals(gson.toJson(pokemonDTO), retStr);
        assertEquals(httpResponse.getStatusLine().getStatusCode(), ok.intValue());
    }

    @Test
    public void getPokemonByIdInvalidId() throws Exception {
        String testUrl = "http://localhost:4567/pokemon/-1";
        HttpGet httpGet = new HttpGet(testUrl);

        HttpResponse httpResponse = httpClientFactory.getHttpClient().execute(httpGet);
        String retStr = EntityUtils.toString(httpResponse.getEntity());
        assertFalse(retStr.isEmpty());
        assertEquals(httpResponse.getStatusLine().getStatusCode(), clientError.intValue());
    }

    @Test
    public void getPokemonByIdNoPokemon() throws Exception {
        String testUrl = "http://localhost:4567/pokemon/1";
        HttpGet httpGet = new HttpGet(testUrl);

        when(mockPokemonService.getPokemonById(1L)).thenReturn(null);

        HttpResponse httpResponse = httpClientFactory.getHttpClient().execute(httpGet);
        assertNull(httpResponse.getEntity());
        assertEquals(httpResponse.getStatusLine().getStatusCode(), noContent.intValue());
    }

    @Test
    public void getPokemonByIds() throws Exception {
        // TODO:
    }

    @Test
    public void getPokemonByType() throws Exception {
        // TODO:
    }

    @Test
    public void getPokemonByName() throws Exception {
        // TODO:
    }

    @Test
    public void getPokemonByIdsTypeAndName() throws Exception {
        // TODO:
    }

    @Test
    public void postPokemon() throws Exception {
        // TODO:
    }

    @Test
    public void postPokemonNoBody() throws Exception {
        // TODO:
    }

    @Test
    public void postPokemonDTOErrors() throws Exception {
        // TODO;
    }

    @Test
    public void postPokemonInvalidJson() throws Exception {
        // TODO:
    }
}
