package br.edu.ifsp.scl.sdm.pcuikt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Setando o adaptador que alimenta o ListView do layout da tela principal
        principalLv.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.opcoes_menu)
        )
        // Setando o OnItemClickListener do ListView
        principalLv.setOnItemClickListener(this)
        // Alterando o título da SupportActionBar
        supportActionBar?.title = getString(R.string.escolha_thread)
    }
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            0 -> startActivity<AcessoDiretoActivity>()
            1 -> startActivity<MessageHandlerActivity>()
            2 -> startActivity<RunnableHandlerActivity>()
            3 -> startActivity<RunOnUiThreadActivity>()
        }
    }
}

