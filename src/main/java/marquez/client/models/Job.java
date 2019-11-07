/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package marquez.client.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import marquez.client.Utils;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@EqualsAndHashCode
@ToString
public final class Job {
  @Getter @NonNull private final JobType type;
  @Getter @NonNull private final String name;
  @Getter @NonNull private final Instant createdAt;
  @Getter @NonNull private final Instant updatedAt;
  @Getter @NonNull private final List<String> inputs;
  @Getter @NonNull private final List<String> outputs;
  @Getter @NonNull private final String location;
  @Nullable private final String description;
  @Nullable private Map<String, String> context;

  public Optional<String> getDescription() {
    return Optional.ofNullable(description);
  }

  public Map<String, String> getContext() {
    return (context == null) ? ImmutableMap.of() : ImmutableMap.copyOf(context);
  }

  public static Job fromJson(@NonNull final String json) {
    return Utils.fromJson(json, new TypeReference<Job>() {});
  }
}
