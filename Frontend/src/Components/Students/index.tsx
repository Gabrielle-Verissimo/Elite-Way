import useFetch from "../../hooks/useFetch";

function Students() {
    const {data, isLoading} = useFetch();

    console.log(data, isLoading);

    return (
        <>
        {/* {isLoading ? <h1>Carregando...</h1> : (
            <div>
                <h1>Alunos</h1>
                <table>
                    <tbody>
                        <tr>
                            <th>Nome</th>
                            <th>Matrícula</th>
                            <th>Curso</th>
                        </tr>
                        {data.map(elem => {
                            return (
                                <tr key={elem.}>

                                </tr>
                            )
                        })}
                    </tbody>
                </table>
            </div>
        )} */}
        </>

    )
}

export default Students;