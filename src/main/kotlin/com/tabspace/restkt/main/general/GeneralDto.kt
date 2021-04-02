package com.tabspace.restkt.main.general

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

/**
 * GOTCHAS:
 * use lateinit to prevent dto class instantiated before validations
 * which can make the kotlin validated the class first before @Valid annotation
 * REF: https://github.com/bindersfullofcode/kotlin-springboot-dto-validation/blob/master/src/main/kotlin/com/bindersfullofcode/springboot/dtovalidation/web/dto/MessageDTO.kt
 * RELATED ISSUES: https://github.com/OpenAPITools/openapi-generator/issues/5121
 */


class ContactUsRequest {
    @field:NotEmpty(message = "validation.isRequired")
    lateinit var name: String

    @field:NotEmpty(message = "validation.isRequired")
    lateinit var email: String

    @field:NotEmpty(message = "validation.isRequired")
    lateinit var message: String

    @Valid
    @field:NotNull(message = "validation.isRequired")
    lateinit var address: ContactAddress
}

class ContactAddress {
    @field:NotNull(message = "validation.isRequired")
    val postal_code: String? = null

    @field:NotNull(message = "validation.isRequired")
    val tenant_name: String? = null
}


data class ContactUsResponse(
    @JsonProperty("name")
    val name: String? = null,

    @JsonProperty("email")
    val email: String? = null,

    @JsonProperty("message")
    val message: String? = null,

    @JsonProperty("address")
    val address: ContactAddress? = null
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