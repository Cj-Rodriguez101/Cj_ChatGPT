package com.cjrodriguez.cjchatgpt.domain.events

import android.net.Uri
import com.cjrodriguez.cjchatgpt.data.datasource.network.internet_check.ConnectivityObserver
import com.cjrodriguez.cjchatgpt.presentation.util.AiType

sealed class ChatListEvents {

    data class SetGptVersion(val aiType: AiType) : ChatListEvents()
    data class SendMessage(
        val isCurrentlyConnectedToInternet: ConnectivityObserver.Status,
        val fileUris: List<String>
    ) :
        ChatListEvents()

    data class SetRecordingState(val isRecordingState: Boolean) : ChatListEvents()

    data class SetShouldShowVoiceSegment(val shouldShowVoiceSegment: Boolean) : ChatListEvents()

    data object NewChat : ChatListEvents()
    data class CopyTextToClipBoard(val messageToCopy: String) : ChatListEvents()
    data class AddImage(val messagesToCopy: List<Uri>) : ChatListEvents()
    data class RemoveImage(val messageToCopy: Uri) : ChatListEvents()
    data object ClearAllImageAndText : ChatListEvents()
    data object CancelChatGeneration : ChatListEvents()
    data object RemoveHeadMessage : ChatListEvents()
    data object StartRecording : ChatListEvents()
    data class SaveFile(val imagePath: String) : ChatListEvents()
    data class SetZoomedImageUrl(val imagePath: String) : ChatListEvents()

    data object UpdatePowerLevel : ChatListEvents()
    data object StopRecording : ChatListEvents()
    data class SetMessage(val message: String) : ChatListEvents()
    data class SetTopicId(val topicId: String) : ChatListEvents()
}