package com.tabspace.restkt.main.general

import javax.validation.constraints.NotEmpty

/**
 * GOTCHAS:
 * use lateinit to prevent dto class instantiated before validations
 * which can make the kotlin validated the class first before @Valid annotation
 * REF: https://github.com/bindersfullofcode/kotlin-springboot-dto-validation/blob/master/src/main/kotlin/com/bindersfullofcode/springboot/dtovalidation/web/dto/MessageDTO.kt
 * RELATED ISSUES: https://github.com/OpenAPITools/openapi-generator/issues/5121
 */

class ContactUsRequest {
    @NotEmpty
    lateinit var name: String

    @NotEmpty
    lateinit var email: String

    @NotEmpty
    lateinit var message: String
}