package com.tabspace.restkt.main.general

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
    @NotEmpty(message = "name required")
    lateinit var name: String

    @NotEmpty(message = "email required")
    lateinit var email: String

    @NotEmpty(message = "message required")
    lateinit var message: String
}

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