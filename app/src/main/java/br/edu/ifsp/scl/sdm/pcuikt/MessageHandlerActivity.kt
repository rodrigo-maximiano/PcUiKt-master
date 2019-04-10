package br.edu.ifsp.scl.sdm.pcuikt

import android.app.Activity
import android.os.Bundle
import android.os.Message

class MessageHandlerActivity : ProgramacaoConcorrenteActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Alterando o título da SupportActionBar
        supportActionBar?.title = getString(R.string.message_handler)
    }
    /* Corpo da thread que será disparada pela thread mãe para tentar carregar as imagens
    No entanto, a thread filha, disparada pela mãe, chama o handler da thread mãe para solicitar
    o carregamento */
    override fun run() {
        // Prepara uma Message para enviar ao Handler
        val carregaImagensMsg = Message()
        carregaImagensMsg.what = CARREGA_IMAGENS_MSG
        // Envia Message para o Handler que vai tratar depois do delay CARREGA_IMAGENS_DELAY (ms)
        carregaImagensHandler.sendMessageDelayed(carregaImagensMsg, CARREGA_IMAGENS_DELAY)
    }
}