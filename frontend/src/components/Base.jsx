import Footer from "./Footer";
import Header from "./Header";

const Base=({title="Blog Application", children})=> {

    return(
        <>
        <Header/>
        {children}
        <Footer/>
        </>
    );

}

export default Base;