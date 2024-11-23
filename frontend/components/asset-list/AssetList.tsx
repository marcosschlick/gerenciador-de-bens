import "./list.css";
import { AssetType, AssetStatus } from "../../interface/AssetData";

interface ListProps {
  assetCode: number;
  description: string;
  type: AssetType;
  acquisitionDate: string;
  value: number;
  status: AssetStatus;

}

export function AssetList({
  assetCode,
  description,
  type,
  acquisitionDate,
  value,
  status,

}: ListProps) {
  return (
    <div className="asset-list">
      <table>
        <thead>
          <tr>
            <th>Código do Bem</th>
            <th>Descrição</th>
            <th>Tipo</th>
            <th>Data de Aquisição</th>
            <th>Valor</th>
            <th>Status</th>
            <th>Departamento</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{assetCode}</td>
            <td>{description}</td>
            <td>{type}</td>
            <td>{acquisitionDate}</td>
            <td>{value.toFixed(2)}</td>
            <td>{status}</td>

          </tr>
        </tbody>
      </table>
    </div>
  );
}