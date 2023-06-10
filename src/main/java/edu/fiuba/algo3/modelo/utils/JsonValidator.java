package edu.fiuba.algo3.modelo.utils;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.exceptions.FormatoJsonInvalidoException;

import java.io.*;
import java.util.Set;



public class JsonValidator {
    public static void validarJsonConSchema(String jsonDataPath, String jsonSchemaPath) throws FormatoJsonInvalidoException, IOException {
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance();
        InputStream schemaStream = new FileInputStream(jsonSchemaPath); // cargo JSON schema
        JsonSchema schema = schemaFactory.getSchema(schemaStream);

        InputStream dataStream = new FileInputStream(jsonDataPath); // cargo JSON data a validar
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode dataNode = objectMapper.readTree(dataStream);

        Set<ValidationMessage> validationMessages = schema.validate(dataNode);

        if (!validationMessages.isEmpty()) {
            throw new FormatoJsonInvalidoException();
        }
    }
}
