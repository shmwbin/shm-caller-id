package in.shmcallerid.app

import android.telecom.Call
import android.telecom.CallScreeningService
import android.util.Log

class CallScreeningService : CallScreeningService() {

    override fun onScreenCall(callDetails: Call.Details) {

        val phoneNumber = callDetails.handle
            ?.schemeSpecificPart
            ?: "Unknown"

        Log.d("SHM_CALLER_ID", "Incoming call: $phoneNumber")

        val response = CallResponse.Builder()
            .setDisallowCall(false)
            .setRejectCall(false)
            .setSilenceCall(false)
            .setSkipCallLog(false)
            .setSkipNotification(false)
            .build()

        respondToCall(callDetails, response)
    }
}
