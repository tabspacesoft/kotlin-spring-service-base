package com.tabspace.restkt.main.general

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import kotlin.reflect.KClass

/**
 * GOTCHAS:
 * use lateinit to prevent dto class instantiated before validations
 * which can make the kotlin validated the class first before @Valid annotation
 * REF: https://github.com/bindersfullofcode/kotlin-springboot-dto-validation/blob/master/src/main/kotlin/com/bindersfullofcode/springboot/dtovalidation/web/dto/MessageDTO.kt
 * RELATED ISSUES: https://github.com/OpenAPITools/openapi-generator/issues/5121
 */

class ContactUsRequest {
    @field:NotEmpty(message = "name is required")
    lateinit var name: String

    @field:NotEmpty(message = "email is required")
    lateinit var email: String

    @field:NotEmpty(message = "message is required")
    lateinit var message: String

    @Valid
    @field:NotNull(message = "address is required")
    lateinit var address: ContactAddress
}

class ContactAddress {
    @field:NotNull(message = "postal_code is required")
    val postal_code: String? = null

    @field:NotNull(message = "tenant_name is required")
    val tenant_name: String? = null
}


data class ContactUsResponse(
    @JsonProperty("name")
    val name: String,

    @JsonProperty("email")
    val email: String,

    @JsonProperty("message")
    val message: String
)

//data class ContactUsRequest (
//    @NotEmpty
//    val name: String,
//
//    @NotEmpty
//    val email: String,
//
//    @NotEmpty(message = "{message.notempty}")
//    val message: String,
//)