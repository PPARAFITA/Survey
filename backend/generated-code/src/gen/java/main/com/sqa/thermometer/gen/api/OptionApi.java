/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.sqa.thermometer.gen.api;

import com.sqa.thermometer.gen.model.ArrayOptionquestionDTO;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-02T09:26:03.226880+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
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
                @Content(mediaType = "application/json", schema = @Schema(implementation = ArrayOptionquestionDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/option",
        produces = { "application/json" }
    )
    
    default ResponseEntity<ArrayOptionquestionDTO> getOption(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"surveyId\" : \"b2f7a764-14b5-45dd-9222-0a4a746f4f7d\", \"questionId\" : \"b2f7a764-14b5-45dd-9222-0a4a746f4f7d\", \"color\" : \"orange\", \"optionId\" : \"b2f7a764-14b5-45dd-9222-0a4a746f4f7d\", \"valorOption\" : \"neutral\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
