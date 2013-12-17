import net.kaleidos.hythloday.marshaller.ActivityMarshaller
import net.kaleidos.hythloday.marshaller.CommentMarshaller
import net.kaleidos.hythloday.marshaller.CategoryMarshaller
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

    customObjectMarshallers( CustomObjectMarshallers ) {
        marshallers = [
            ref("activityMarshaller"),
            ref("commentMarshaller"),
            ref("categoryMarshaller")
        ]
    }
}
