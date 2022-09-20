import com.rff.ktorclientbasics.model.Profile
import com.rff.ktorclientbasics.model.TokenResponse
import com.rff.ktorclientbasics.util.Constants.BASE_URL
import com.rff.ktorclientbasics.util.Constants.TOKEN_ENDPOINT
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*


class KtorEngine {

    private val tokenClient = HttpClient(CIO) {
        expectSuccess = true
        install(JsonFeature) {
            serializer = GsonSerializer {
                setPrettyPrinting()
                disableHtmlEscaping()
            }
        }
    }
    private val client = HttpClient(CIO) {
        expectSuccess = true
        install(JsonFeature) {
            serializer = GsonSerializer {
                setPrettyPrinting()
                disableHtmlEscaping()
            }
        }

        install(Auth) {
            lateinit var tokenInfo: TokenResponse
            var refreshTokenInfo: TokenResponse
            val param = Parameters.build {
                append("username", "julius@digitres.com")
                append("password", "secret")
            }
            println("param::$param")

            bearer {
                loadTokens {
                    tokenInfo = tokenClient.submitForm(
                        url = "$BASE_URL$TOKEN_ENDPOINT",
                        formParameters = param
                    )
                    println("tokenInfo::$tokenInfo")

                    tokenInfo.token?.let {
                        BearerTokens(
                            accessToken = it.payload!!,
                            refreshToken = it.payload!!
                        )
                    }

                }

                refreshTokens {
                    refreshTokenInfo = tokenClient.submitForm(
                        url = "$BASE_URL$TOKEN_ENDPOINT",
                        param
                    )
                    BearerTokens(
                        accessToken = refreshTokenInfo.token?.payload!!,
                        refreshToken = tokenInfo.token?.payload!!
                    )
                }
            }
        }
    }

    suspend fun getProfile(email: String): Profile {
        return client.get("http://192.168.100.16:8000/api/v1/profile?account=$email")
    }
}