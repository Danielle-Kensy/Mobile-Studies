package juliano.correa.final_project.service

import juliano.correa.final_project.model.Character
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface CharacterService {
    @GET("/characters")
    fun findAll() : Call<List<juliano.correa.final_project.model.Character>>

    @POST("/characters")
    fun save(@Body character: juliano.correa.final_project.model.Character) : Call<juliano.correa.final_project.model.Character>

    @PUT("/characters")
    fun update(@Body character: juliano.correa.final_project.model.Character) : Call<Character>

    @DELETE("/characters/{id}")
    fun delete(@Path("id") id: Int) : Call<ResponseBody>
}