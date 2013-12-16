import net.kaleidos.hythloday.marshaller.ActivityMarshaller
import net.kaleidos.hythloday.util.CustomObjectMarshallers

// Place your Spring DSL code here
beans = {
    activityMarshaller(ActivityMarshaller){
        activityService = ref("activityService")
    }

    customObjectMarshallers( CustomObjectMarshallers ) {
        marshallers = [
            ref("activityMarshaller")
        ]
    }
}
