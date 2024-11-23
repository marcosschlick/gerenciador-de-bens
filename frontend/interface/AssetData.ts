export enum AssetType {
    MESA = "MESA",
    CADEIRA = "CADEIRA",
    COMPUTADOR = "COMPUTADOR",
    ROTEADOR = "ROTEADOR",
    MONITOR = "MONITOR",
    MOUSE = "MOUSE",
    TECLADO = "TECLADO",
    IMPRESSORA = "IMPRESSORA",
    ARMARIO = "ARMARIO",
    PROJETOR = "PROJETOR",
    OUTRO = "OUTRO"
}

export enum AssetStatus {
    ATIVO = "ATIVO",
    EM_MANUTENCAO = "EM_MANUTENCAO",
    DANIFICADO = "DANIFICADO",
    INATIVO = "INATIVO",
    BAIXADO = "BAIXADO"
}

export interface AssetData {
    id: number;
    assetCode: number;
    description: string;
    type: AssetType;
    acquisitionDate: string;
    value: number;
    status: AssetStatus;
}
