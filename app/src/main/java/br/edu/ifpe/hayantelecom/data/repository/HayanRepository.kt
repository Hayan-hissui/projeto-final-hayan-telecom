/*
 * Hayan Telecom - App Android
 * Arquivo: HayanRepository.kt
 * Responsável: Alberto Vinicius e Gabriel Fernando / Dados
 * Descrição: Repositório centralizador de dados da Hayan Telecom. Popula os dados iniciais do Room e expõe os Flows.
 */

package br.edu.ifpe.hayantelecom.data.repository

import br.edu.ifpe.hayantelecom.data.local.AppDatabase
import br.edu.ifpe.hayantelecom.model.Cliente
import br.edu.ifpe.hayantelecom.model.Cobranca
import br.edu.ifpe.hayantelecom.model.Plano
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext

class HayanRepository(private val database: AppDatabase) {

    val clienteFlow: Flow<Cliente?> = database.clienteDao().getCliente()
    val planoFlow: Flow<Plano?> = database.planoDao().getPlano()
    val cobrancasFlow: Flow<List<Cobranca>> = database.cobrancaDao().getAllCobrancas()
    val cobrancaPendenteFlow: Flow<Cobranca?> = database.cobrancaDao().getCobrancaPendente()

    suspend fun getCobrancaById(id: String): Cobranca? = withContext(Dispatchers.IO) {
        database.cobrancaDao().getCobrancaById(id)
    }

    suspend fun popularDadosIniciaisSeNecessario() = withContext(Dispatchers.IO) {
        val clienteExistente = clienteFlow.firstOrNull()
        if (clienteExistente == null) {
            val clientePadrao = Cliente(
                id = "c1",
                nome = "Jorge Silva",
                email = "jorge@hayantelecom.com.br",
                cpf = "123.456.789-00",
                codigoCliente = "HT-001284",
                endereco = "Rua das Telecomunicações, 100 - Recife, PE"
            )
            database.clienteDao().insertCliente(clientePadrao)
        }

        val planoExistente = planoFlow.firstOrNull()
        if (planoExistente == null) {
            val planoPadrao = Plano(
                id = "p1",
                nome = "Hayan Fibra Ultra 500 Mega",
                velocidade = "500 Mbps Download / 250 Mbps Upload",
                valorMensalidade = 99.90,
                status = "ATIVO"
            )
            database.planoDao().insertPlano(planoPadrao)
        }

        val cobrancasExistentes = cobrancasFlow.firstOrNull()
        if (cobrancasExistentes.isNullOrEmpty()) {
            val listaCobrancas = listOf(
                Cobranca(
                    id = "cob_101",
                    clienteId = "c1",
                    valor = 99.90,
                    dataVencimento = "15/12/2026",
                    status = "EM_ABERTO",
                    codigoBoleto = "23793.38128 60000.123456 7 8900000009990",
                    descricao = "Mensalidade Dezembro/2026 - 500 Mega"
                ),
                Cobranca(
                    id = "cob_100",
                    clienteId = "c1",
                    valor = 99.90,
                    dataVencimento = "15/11/2026",
                    status = "PAGO",
                    codigoBoleto = "23793.38128 60000.123456 7 8900000009980",
                    descricao = "Mensalidade Novembro/2026 - 500 Mega"
                ),
                Cobranca(
                    id = "cob_099",
                    clienteId = "c1",
                    valor = 99.90,
                    dataVencimento = "15/10/2026",
                    status = "PAGO",
                    codigoBoleto = "23793.38128 60000.123456 7 8900000009970",
                    descricao = "Mensalidade Outubro/2026 - 500 Mega"
                )
            )
            database.cobrancaDao().insertCobrancas(listaCobrancas)
        }
    }

    suspend fun simularPagamento(cobrancaId: String): Boolean = withContext(Dispatchers.IO) {
        val cobranca = database.cobrancaDao().getCobrancaById(cobrancaId) ?: return@withContext false
        val cobrancaPaga = cobranca.copy(status = "PAGO")
        database.cobrancaDao().insertCobranca(cobrancaPaga)
        true
    }
}
