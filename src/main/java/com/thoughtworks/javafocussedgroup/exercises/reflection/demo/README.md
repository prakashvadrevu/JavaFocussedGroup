# Reflections / Annotations Exercise

### Problem statement

Build a JSON serializer / deserializer called **`Tson`**. It should support:
* Dealing with private member variables
* `@JsonIgnore` annotation - Tson should ignore these fields
* A field of type `List` should be converted to `JsonArray` and vice versa
* A field of type `Map` should be converted to `JsonObject` and vice versa
* If the target object consists of a custom (non-primitive) objects, Tson should recursively serialize / deserialize them as well.

Have fun with Reflection & Annotations!!