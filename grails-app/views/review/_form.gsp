<fieldset class="form">
    <f:with bean="review">

        <div class="row">
            <div class="col-sm-4">
                <fieldset>
                    <legend>Allgemeines:</legend>
                    <b:field property="date" widget-inputType="date"/>
                    <f:field property="koeniginGesehen"/>
                    <b:field property="notes" widget-rows="12"/>
                </fieldset>
            </div>

            <div class="col-sm-4">
                <fieldset>
                    <legend>allgemeiner Befund:</legend>
                    <b:field property="egg" widget="rating"/>
                    <b:field property="larva" widget="rating"/>
                    <b:field property="cellCapped" widget="rating"/>
                    <b:field property="wabensitz" widget="rating"/>
                    <b:field property="sanftmut" widget="rating"/>
                    <b:field property="volksstaerke" widget="rating"/>
                </fieldset>
            </div>

            <div class="col-sm-4">
                <fieldset>
                    <legend>Gegeben/ genommen:</legend>
                    <b:field property="broodChamber"/>
                    <b:field property="honeyChamber"/>
                    <b:field property="mittelwaende"/>
                    <b:field property="brutwaben"/>
                    <b:field property="futterwaben"/>
                    <b:field property="drohnenwaben"/>
                </fieldset>
            </div>
        </div>
    </f:with>
</fieldset>