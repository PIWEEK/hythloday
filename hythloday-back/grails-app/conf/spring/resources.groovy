import net.kaleidos.hythloday.marshaller.ActivityMarshaller
import net.kaleidos.hythloday.marshaller.CommentMarshaller
import net.kaleidos.hythloday.util.CustomObjectMarshallers

// Place your Spring DSL code here
beans = {
    activityMarshaller(ActivityMarshaller) {
        activityService = ref("activityService")
    }

    commentMarshaller(CommentMarshaller) {
        commentService = ref("commentService")
    }

    customObjectMarshallers( CustomObjectMarshallers ) {
        marshallers = [
            ref("activityMarshaller"),
            ref("commentMarshaller")
        ]
    }
}
