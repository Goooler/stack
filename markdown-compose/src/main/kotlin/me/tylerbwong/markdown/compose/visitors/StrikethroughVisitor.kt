package me.tylerbwong.markdown.compose.visitors

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import me.tylerbwong.markdown.compose.builder.buildMarkdown
import org.intellij.markdown.ast.ASTNode

internal object StrikethroughVisitor : Visitor {

    override fun accept(node: ASTNode, builder: AnnotatedString.Builder, content: String) {
        builder.withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)) {
            node.children
                // Drop "~~" token before and after
                .drop(2)
                .dropLast(2)
                .forEach { buildMarkdown(it, content) }
        }
    }
}
