import WithdrawForm from "../Transaction/Transaction_Retreat/Retreat";
import TransferForm from "../Transaction/Transaction_between_account/TransactionBetweenAccount";
import IncomingTransferForm from "../Transaction/Transaction_other_bank/TransactionOtherBank";

function AllTransaction(){
    return (
        <>
        <WithdrawForm/>
        <IncomingTransferForm/>
        <TransferForm/>
        </>
    )
}
export default AllTransaction;