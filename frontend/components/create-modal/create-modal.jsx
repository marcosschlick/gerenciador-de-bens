import { useEffect, useState } from 'react';
import { useFoodDataMutate } from '../../hooks/useFoodDataMutate';
import "./modal.css";

const Input = ({ label, value, updateValue }) => {
    return (
        <>
            <label>{label}</label>
            <input value={value} onChange={event => updateValue(event.target.value)} />
        </>
    )
}

const statusOptions = ["ATIVO", "EM_MANUTENCAO", "DANIFICADO", "INATIVO", "BAIXADO"];

export function CreateModal({ closeModal }) {
    const [assetCode, setAssetCode] = useState("");
    const [description, setDescription] = useState("");
    const [type, setType] = useState(statusOptions[0]);
    const [acquisitionDate, setAcquisitionDate] = useState("");
    const [value, setValue] = useState(0);
    const [status, setStatus] = useState(statusOptions[0]);
    
    const { mutate, isSuccess, isLoading } = useFoodDataMutate();

    const submit = () => {
        const assetData = {
            assetCode,
            description,
            type,
            acquisitionDate,
            value,
            status
        };
        mutate(assetData);
    }

    useEffect(() => {
        if (!isSuccess) return;
        closeModal();
    }, [isSuccess]);

    return (
        <div className="modal-overlay">
            <div className="modal-body">
                <h2>Cadastre um novo item</h2>
                <form className="input-container">
                    <Input label="Asset Code" value={assetCode} updateValue={setAssetCode} />
                    <Input label="Description" value={description} updateValue={setDescription} />
                    <Input label="Acquisition Date" value={acquisitionDate} updateValue={setAcquisitionDate} />
                    <Input label="Value" value={value} updateValue={setValue} />
                    <div>
                        <label>Status</label>
                        <select value={status} onChange={event => setStatus(event.target.value)}>
                            {statusOptions.map(option => (
                                <option key={option} value={option}>{option}</option>
                            ))}
                        </select>
                    </div>
                    <div>
                        <label>Type</label>
                        <select value={type} onChange={event => setType(event.target.value)}>
                            {statusOptions.map(option => (
                                <option key={option} value={option}>{option}</option>
                            ))}
                        </select>
                    </div>
                </form>
                <button onClick={submit} className="btn-secondary">
                    {isLoading ? 'Postando...' : 'Postar'}
                </button>
            </div>
        </div>
    );
}
