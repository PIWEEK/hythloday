import net.kaleidos.hythloday.marshaller.*
import net.kaleidos.hythloday.util.CustomObjectMarshallers

// Place your Spring DSL code here
beans = {
    activityMarshaller(ActivityMarshaller) {
        activityService = ref("activityService")
    }

    commentMarshaller(CommentMarshaller) {
        commentService = ref("commentService")
    }

    categoryMarshaller(CategoryMarshaller) {}
    zoneMarshaller(ZoneMarshaller) {}

    customObjectMarshallers( CustomObjectMarshallers ) {
        marshallers = [
            ref("activityMarshaller"),
            ref("commentMarshaller"),
            ref("categoryMarshaller"),
            ref("zoneMarshaller")
        ]
    }
}
