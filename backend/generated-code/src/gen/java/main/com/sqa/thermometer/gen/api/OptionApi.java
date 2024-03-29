/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.sqa.thermometer.gen.api;

import com.sqa.thermometer.gen.model.OptionQuestionDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-24T18:53:38.194613+01:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
@Validated
@Tag(name = "Option_question", description = "This will be use to retrieve options of questions")
public interface OptionApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /option : Get all the options for the question
     * Get all the options of a question
     *
     * @return Successful operation (status code 200)
     */
    @Operation(
        operationId = "getOption",
        summary = "Get all the options for the question",
        description = "Get all the options of a question",
        tags = { "Option_question" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OptionQuestionDTO.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/option",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<OptionQuestionDTO>> getOption(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"surveyId\" : \"47455c16-41ee-4622-8a75-697aacfa2466\", \"valor_option\" : \"good\", \"questionId\" : \"47455c16-41ee-4622-8a75-697aacfa2466\", \"color\" : \"green\", \"optionId\" : \"47455c16-41ee-4622-8a75-697aacfa2466\" }, { \"surveyId\" : \"47455c16-41ee-4622-8a75-697aacfa2466\", \"valor_option\" : \"good\", \"questionId\" : \"47455c16-41ee-4622-8a75-697aacfa2466\", \"color\" : \"green\", \"optionId\" : \"47455c16-41ee-4622-8a75-697aacfa2466\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
