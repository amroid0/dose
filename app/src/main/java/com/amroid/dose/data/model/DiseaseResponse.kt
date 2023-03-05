import com.google.gson.annotations.SerializedName

data class Problem(
    @SerializedName("Diabetes") val diabetes: List<Diabetes>,
    @SerializedName("Asthma") val asthma: List<Asthma>
)

data class Diabetes(
    @SerializedName("medications") val medications: List<Medication>,
    @SerializedName("labs") val labs: List<Lab>
)

data class Medication(
    @SerializedName("medicationsClasses") val medicationClasses: List<MedicationClass>
)

data class MedicationClass(
    @SerializedName("className") val className: List<AssociatedDrug>,
    @SerializedName("className2") val className2: List<AssociatedDrug>
)

data class AssociatedDrug(
    @SerializedName("associatedDrug") val associatedDrug: List<Drug>,
    @SerializedName("associatedDrug#2") val associatedDrug2: List<Drug>
)

data class Drug(
    @SerializedName("name") val name: String,
    @SerializedName("dose") val dose: String,
    @SerializedName("strength") val strength: String
)

data class Lab(
    @SerializedName("missing_field") val missingField: String
)

data class Asthma(
    @SerializedName("medications") val medications: List<Medication>,
    @SerializedName("labs") val labs: List<Lab>
)
