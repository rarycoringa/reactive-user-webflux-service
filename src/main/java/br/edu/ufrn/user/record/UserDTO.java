package br.edu.ufrn.user.record;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDTO(
    String id,
    String name,
    Integer age,
    @JsonProperty("created_at") @JsonFormat(shape = JsonFormat.Shape.STRING) Instant createdAt,
    @JsonProperty("updated_at") @JsonFormat(shape = JsonFormat.Shape.STRING) Instant updatedAt
) {}
